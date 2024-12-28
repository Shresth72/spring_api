package com.one_time_token.magic_link.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

  @RequestMapping("/ott/sent")
  String ottSend() {
    return "ott-sent";
  }
}
