package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Collection;

import java.util.List;

public interface CollectionServices {

    List<Collection> getAllCollections();

    Collection getCollectionById(Long id);

    Collection createCollection(Collection collection);

    Collection updateCollection(Collection collection);

    void deleteCollectionById(Long id);
}
