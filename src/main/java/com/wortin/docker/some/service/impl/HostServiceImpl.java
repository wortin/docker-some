package com.wortin.docker.some.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wortin.docker.some.service.HostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wortin
 */
@Service
@Slf4j
public class HostServiceImpl implements HostService {
    @Override
    public String getHostIP() {
        log.info("start to getHostIP");
        Set<String> ipLocalSet = new HashSet<>();
        try {
            Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
                Enumeration ipAddrEnum = ni.getInetAddresses();
                while (ipAddrEnum.hasMoreElements()) {
                    InetAddress addr = (InetAddress) ipAddrEnum.nextElement();
                    if (addr.isLoopbackAddress() == true) {
                        continue;
                    }
                    String ip = addr.getHostAddress();
                    if (ip.indexOf(":") != -1) {
                        //skip the IPv6 addr
                        continue;
                    }
                    ipLocalSet.add(ip);
                }
            }
        } catch (SocketException e) {
            System.out.println("无法获取IP，IP校验失败");
            e.printStackTrace();
        }
        log.info("finish to getHostIP");
        return JSONObject.toJSONString(ipLocalSet);
    }
}
