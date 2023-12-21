package com.example.DSAMAssignment.controller;

import com.example.DSAMAssignment.dtos.*;
import com.example.DSAMAssignment.model.*;
import com.example.DSAMAssignment.respository.*;
import com.example.DSAMAssignment.services.BottleService;
import com.example.DSAMAssignment.services.CrateService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BottleService bottleService;

    @Autowired
    private CrateService crateService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BottleRepository bottleRepository;

    @Autowired
    private CrateRepository crateRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "/home")
    public String viewHomePage(Model model) {
        MainDTO mainDTO = new MainDTO();
        mainDTO.setBottleDTOS(bottleService.getAllBottles());
        mainDTO.setCrateDTOS(crateService.getAllCrates());
        model.addAttribute("response", mainDTO);
        return "home";
    }

    @GetMapping("/add-bottle-to-cart")
    public String addBottlesToCart(@RequestParam("id") Long id, HttpSession httpSession) {
        CartDTO cartDTO = null;
        Bottle bottle = bottleRepository.getReferenceById(id);
        boolean bottleAvailable = false;

        if (bottle != null && bottle.getInStock() > 0) {
            if (httpSession.getAttribute("cart") != null) {
                cartDTO = (CartDTO) httpSession.getAttribute("cart");
                if (cartDTO.getBottleDTOS() != null) {
                    List<BottleDTO> bottleDTOS = cartDTO.getBottleDTOS();
                    int i = 0;
                    for(BottleDTO bottleDTO : bottleDTOS) {
                        if (bottleDTO.getId().equals(bottle.getId())) {
                            bottleDTO.setTotalCount(bottleDTO.getTotalCount() + 1);
                            bottleDTOS.remove(i);
                            bottleDTOS.add(bottleDTO);
                            cartDTO.setBottleDTOS(bottleDTOS);
                            bottleAvailable = true;
                            break;
                        }
                        i++;
                    }
                }

                if (!bottleAvailable) {
                    List<BottleDTO> bottleDTOS = cartDTO.getBottleDTOS();
                    if (bottleDTOS == null) {
                        bottleDTOS = new ArrayList<>();
                    }
                    BottleDTO bottleDTO = BottleDTO.valueof(bottle);
                    bottleDTO.setTotalCount(1);
                    bottleDTOS.add(bottleDTO);
                    cartDTO.setBottleDTOS(bottleDTOS);
                }
                httpSession.setAttribute("cart", cartDTO);
            } else {
                CartDTO cartDTO1 = new CartDTO();
                List<BottleDTO> bottleDTOS = new ArrayList<>();
                BottleDTO bottleDTO = BottleDTO.valueof(bottle);
                bottleDTO.setTotalCount(1);
                bottleDTOS.add(bottleDTO);
                cartDTO1.setBottleDTOS(bottleDTOS);
                httpSession.setAttribute("cart", cartDTO1);
            }
            bottle.setInStock(bottle.getInStock() - 1);
            bottleRepository.save(bottle);
        }
        return "redirect:/home";
    }

    @GetMapping("/add-crate-to-cart")
    public String addCratesToCart(@RequestParam("id") Long id, HttpSession httpSession) {
        CartDTO cartDTO = null;
        Crate crate = crateRepository.getReferenceById(id);
        boolean bottleAvailable = false;

        if (crate != null && crate.getCratesInStock() > 0) {
            if (httpSession.getAttribute("cart") != null) {
                cartDTO = (CartDTO) httpSession.getAttribute("cart");
                if (cartDTO.getCrateDTOS() != null) {
                    int i = 0;
                    List<CrateDTO> crateDTOS = cartDTO.getCrateDTOS();
                    for(CrateDTO crateDTO : crateDTOS) {
                        if (crateDTO.getId().equals(crate.getId())) {
                            crateDTO.setTotalCount(crateDTO.getTotalCount() + 1);
                            crateDTOS.remove(i);
                            crateDTOS.add(crateDTO);
                            cartDTO.setCrateDTOS(crateDTOS);
                            bottleAvailable = true;
                            break;
                        }
                        i++;
                    }
                }

                if (!bottleAvailable) {
                    List<CrateDTO> crateDTOS = cartDTO.getCrateDTOS();
                    if (crateDTOS == null) {
                        crateDTOS = new ArrayList<>();
                    }
                    CrateDTO crateDTO = new CrateDTO();
                    crateDTO = CrateDTO.valueOf(crate);
                    crateDTO.setTotalCount(1);
                    crateDTOS.add(crateDTO);
                    cartDTO.setCrateDTOS(crateDTOS);
                }
                httpSession.setAttribute("cart", cartDTO);
            } else {
                CartDTO cartDTO1 = new CartDTO();
                List<CrateDTO> crateDTOS = new ArrayList<>();
                CrateDTO crateDTO = CrateDTO.valueOf(crate);
                crateDTO.setTotalCount(1);
                crateDTOS.add(crateDTO);
                cartDTO1.setCrateDTOS(crateDTOS);
                httpSession.setAttribute("cart", cartDTO1);
            }
            crate.setCratesInStock(crate.getCratesInStock() - 1);
            crateRepository.save(crate);
        }
        return "redirect:/home";
    }

    @GetMapping(value = "/cart")
    public String viewCartPage(Model model, HttpSession httpSession) {
        double totalPrice = 0.0;
        CartDTO cartDTO = (CartDTO) httpSession.getAttribute("cart");
        if (cartDTO != null && cartDTO.getBottleDTOS() != null) {
            for (BottleDTO bottleDTO : cartDTO.getBottleDTOS()) {
                totalPrice += (bottleDTO.getPrice() * bottleDTO.getTotalCount());
            }
        }

        if (cartDTO != null && cartDTO.getCrateDTOS() != null) {
            for (CrateDTO crateDTO : cartDTO.getCrateDTOS()) {
                totalPrice += (crateDTO.getPrice() * crateDTO.getTotalCount());
            }
        }

        httpSession.setAttribute("total", totalPrice);

        return "cart";
    }

    @GetMapping(value = "/orders")
    public String viewOrders(Model model, HttpSession httpSession) {
//        Users users = (Users) httpSession.getAttribute("users");
//        List<Orders> orders = orderRepository.findByUsersId(users.getId());
        List<Orders> orders = orderRepository.findAll();
        MainDTO mainDTO = new MainDTO();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Orders order : orders) {
            List<OrderItem> orderItems = orderItemRepository.findByOrderId(order.getId());
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setPrice(order.getPrice());
            List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
            orderItems.forEach(orderItem -> {
                OrderItemDTO orderItemDTO = new OrderItemDTO();
                if (orderItem.getBottle() != null) {
                    orderItemDTO.setName(orderItem.getBottle().getName());
                    orderItemDTO.setImage(orderItem.getBottle().getBottlePic());
                    orderItemDTO.setPrice(orderItem.getBottle().getPrice());
                    orderItemDTO.setPosition(orderItem.getPosition());
                }
                if (orderItem.getCrate() != null) {
                    orderItemDTO.setName(orderItem.getCrate().getName());
                    orderItemDTO.setImage(orderItem.getCrate().getCratePic());
                    orderItemDTO.setPrice(orderItem.getCrate().getPrice());
                    orderItemDTO.setPosition(orderItem.getPosition());
                }
                orderItemDTOS.add(orderItemDTO);
            });
            orderDTO.setOrderItemDTOS(orderItemDTOS);
            orderDTOS.add(orderDTO);
        }
        mainDTO.setOrderDTOS(orderDTOS);
        model.addAttribute("response", mainDTO);
        return "orders";
    }

    @PostMapping(value = "/place-order")
    public String placeOrder(AddreesDTO addreesDTO, HttpSession httpSession) {
        Address address = Address.valueOf(addreesDTO);
        Users users = (Users) httpSession.getAttribute("user");
        address.setUsers(users);
        addressRepository.save(address);
        Orders orders = new Orders();
        double total = (double) httpSession.getAttribute("total");
        orders.setPrice(total);
        orders.setUsers(users);
        orders = orderRepository.save(orders);
        CartDTO cartDTO = (CartDTO) httpSession.getAttribute("cart");
        if (cartDTO.getBottleDTOS() != null) {
            for (BottleDTO bottleDTO : cartDTO.getBottleDTOS()) {
                OrderItem orderItem = new OrderItem();
                Bottle bottle = bottleRepository.getReferenceById(bottleDTO.getId());
                orderItem.setBottle(bottle);
                orderItem.setOrder(orders);
                orderItem.setPosition("1");
                orderItem.setPrice(bottleDTO.getPrice() * bottleDTO.getTotalCount());
//                orderItem.setQuantity(bottleDTO.getTotalCount());
                orderItemRepository.save(orderItem);
            }
        }

        if (cartDTO.getCrateDTOS() != null) {
            for (CrateDTO crateDTO : cartDTO.getCrateDTOS()) {
                OrderItem orderItem = new OrderItem();
                Crate crate = crateRepository.getReferenceById(crateDTO.getId());
                orderItem.setCrate(crate);
                orderItem.setOrder(orders);
                orderItem.setPosition("1");
                orderItem.setPrice(crateDTO.getPrice() * crateDTO.getTotalCount());
//                orderItem.setQuantity(crateDTO.getTotalCount());
                orderItemRepository.save(orderItem);
            }
        }
        httpSession.removeAttribute("cart");
        return "redirect:/orders";
    }

}
