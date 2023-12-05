package com.camping.camping.applications;


import com.camping.camping.domains.CartItem;
import com.camping.camping.domains.Order;
import com.camping.camping.domains.OrderItem;
import com.camping.camping.domains.User;
import com.camping.camping.domains.vo.Money;
import com.camping.camping.domains.vo.Name;
import com.camping.camping.dtos.CartItemIdsDto;
import com.camping.camping.dtos.GetCartItemByCartItemIdDto;
import com.camping.camping.exceptions.CartItemNotExist;
import com.camping.camping.exceptions.NameNotExist;
import com.camping.camping.repositories.CartItemRepository;
import com.camping.camping.repositories.OrderItemRepository;
import com.camping.camping.repositories.OrderRepository;
import com.camping.camping.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.camping.camping.domains.vo.OrderStatus.READY;

@Service
@Transactional
public class AddOrderService {

    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;


    public AddOrderService(UserRepository userRepository, CartItemRepository cartItemRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public String addOrder(String name, String receiverName, String address, List<CartItemIdsDto> cartItemIds){
        Long cartTotalPrice = 0L;
        User user = userRepository
                .findByName(name)
                .orElseThrow(NameNotExist::new);

        Order newOrder = new Order(
                user,
                new Money(0L),
                new Name(receiverName),
                address,
                READY);

        orderRepository.save(newOrder);


        for (CartItemIdsDto cartItemId : cartItemIds) {
            GetCartItemByCartItemIdDto result = cartItemRepository.findByCartItemId(cartItemId.getCartItemId());


            Long unitPrice = result.getProductPirce().asLong()
                    + result.getProductFirstOptinPrice().asLong()
                    + result.getProductSecondOptinPrice().asLong();

            Long totalPrice = unitPrice * result.getQuantity();
            cartTotalPrice += totalPrice;

            OrderItem newOrderItem = new OrderItem(
                    newOrder,
                    result.getProduct(),
                    result.getProductName(),
                    result.getProductPirce(),
                    result.getProductFirstOption(),
                    result.getProductFirstOptionName(),
                    result.getProductFirstOptinPrice(),
                    result.getProductSecondOption(),
                    result.getProductSecondOptionName(),
                    result.getProductSecondOptinPrice(),
                    new Money(unitPrice),
                    result.getQuantity(),
                    new Money(totalPrice)
            );

            orderItemRepository.save(newOrderItem);

             CartItem cartItem = cartItemRepository.findById(cartItemId.getCartItemId()).orElseThrow(CartItemNotExist::new);

             cartItemRepository.delete(cartItem);
        }

        newOrder.changeTotalPrice(new Money(cartTotalPrice));
        orderRepository.save(newOrder);

        return "success";
    }

}
