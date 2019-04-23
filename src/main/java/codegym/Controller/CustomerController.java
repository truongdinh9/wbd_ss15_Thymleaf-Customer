package codegym.Controller;

import codegym.model.Customer;
import codegym.service.CustomerService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService =new CustomerService();
    @GetMapping
    public String index(Model model){
        model.addAttribute("customers",customerService.fillAll());
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("/save")
    public String save(Customer customer ,RedirectAttributes redirect){
        int id= (++customerService.key);
        customer.setId(id);
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Saved customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        Customer customer=customerService.findById(id);
        model.addAttribute("customer",customer);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Customer customer, RedirectAttributes redirect){
        int id =customer.getId();
        customerService.update(customer.getId(),customer);
        redirect.addFlashAttribute("message","Edited customer successfully");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        Customer customer=customerService.findById(id);
        model.addAttribute("customer",customer);
        return "delete";
    }
    @PostMapping("/remove")
    public String remove(Customer customer, RedirectAttributes redirect){
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("message","Deleted customer successfully");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        Customer customer=customerService.findById(id);
        model.addAttribute("customer",customer);
        return "view";
    }

}
