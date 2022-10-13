package ru.balovin.spring.service.impl;

import org.springframework.stereotype.Service;
import ru.balovin.spring.dao.ResourceDao;
import ru.balovin.spring.service.ResourceService;

import java.io.InputStream;

@Service
public class ResourceServiceImpl implements ResourceService {
    private final ResourceDao resourceDao;

    public ResourceServiceImpl(ResourceDao resourceDao) {
        this.resourceDao = resourceDao;
    }

    @Override
    public InputStream getResourceAsStream(String name) {
        return resourceDao.getResourceAsStream(name);
    }
}
