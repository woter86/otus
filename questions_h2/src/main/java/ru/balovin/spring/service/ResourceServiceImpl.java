package ru.balovin.spring.service;

import org.springframework.stereotype.Service;
import ru.balovin.spring.dao.ResourceDao;

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
