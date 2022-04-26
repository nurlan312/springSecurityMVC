package com.peaksoft.springsecuritymvc.services;

import com.peaksoft.springsecuritymvc.models.Group;
import com.peaksoft.springsecuritymvc.reposiroties.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;

    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    public void saveGroup(Group group) {
        repository.save(group);
    }

    public Group getByIdGroup(Long id) {
        return repository.findById(id).get();
    }

    public void deleteByIdGroup(Long id) {
        repository.deleteById(id);
    }

    public void updateGroup(Group group, Long id) {
        repository.getById(id);
        repository.save(group);
    }

}
