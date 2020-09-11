package com.wortin.docker.some.controller;

import com.wortin.docker.some.service.HostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wortin
 */
@RestController
@RequestMapping("host")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping("/ip")
    public String getHostIP() {
        return hostService.getHostIP();
    }
}
