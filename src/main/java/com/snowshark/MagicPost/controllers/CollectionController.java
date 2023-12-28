package com.snowshark.MagicPost.controllers;

import com.snowshark.MagicPost.entities.Collection;
import com.snowshark.MagicPost.services.CollectionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collections")
public class CollectionController {

    @Autowired
    private CollectionServices collectionService;

    @GetMapping
    public ResponseEntity<List<Collection>> getAllCollections() {
        List<Collection> collections = collectionService.getAllCollections();
        return ResponseEntity.ok(collections);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collection> getCollectionById(@PathVariable Long id) {
        Collection collection = collectionService.getCollectionById(id);
        return ResponseEntity.ok(collection);
    }

    @PostMapping
    public ResponseEntity<Collection> createCollection(@RequestBody Collection collection) {
        Collection createdCollection = collectionService.createCollection(collection);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCollection);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Collection> updateCollection(@PathVariable Long id, @RequestBody Collection collection) {
        collection.setId(id); // Ensure ID is set for update
        Collection updatedCollection = collectionService.updateCollection(collection);
        return ResponseEntity.ok(updatedCollection);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollectionById(@PathVariable Long id) {
        collectionService.deleteCollectionById(id);
        return ResponseEntity.noContent().build();
    }
}
