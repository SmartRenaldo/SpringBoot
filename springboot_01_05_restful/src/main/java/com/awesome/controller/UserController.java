package com.awesome.controller;

import com.awesome.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yiqi Li
 * @RestController = @Controller + @ResponseBody
 */
/*@Controller
@ResponseBody*/
@RestController
@RequestMapping("/users")
public class UserController {

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String save(@RequestBody User user) {
        String s = "saving user "+ user + "........";
        System.out.println(s);

        return s;
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        String s = "deleting user " + id + "........";
        System.out.println(s);

        return s;
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String queryById(@PathVariable Integer id) {
        String s = "querying user " + id + "........";
        System.out.println(s);

        return s;
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String queryAll() {
        String s = "query all users........";
        System.out.println(s);

        return s;
    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public String update(@RequestBody User user) {
        String s = "updating user" + user + "........";
        System.out.println(s);

        return s;
    }
}
