package com.zy.blog.server.conf.support;

import com.zy.blog.server.exception.ClientNotFoundException;
import com.zy.blog.server.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

@Configuration
public class DefineClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Clients clients = clientMapper.getClientsByClentId(clientId);
        if (null == clients) {
            throw new ClientNotFoundException("客户端不存在");
        }
        return new DefineClientDetails(clients);
    }
}
