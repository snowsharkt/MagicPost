package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Collection;
import com.snowshark.MagicPost.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServicesImplement implements CollectionServices {
    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    @Override
    public Collection getCollectionById(Long id) {
        return collectionRepository.findById(id).orElse(null);
    }

    @Override
    public Collection createCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    @Override
    public Collection updateCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    @Override
    public void deleteCollectionById(Long id) {
        collectionRepository.deleteById(id);
    }
}
