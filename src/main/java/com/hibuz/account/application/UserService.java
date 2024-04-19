package com.hibuz.account.application;

import com.hibuz.account.dao.AuthorityRepository;
import com.hibuz.account.domain.Authority;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing users.
 */
@AllArgsConstructor
@Service
@Transactional
public class UserService {

    private final AuthorityRepository authorityRepository;

    /**
     * Gets a list of all the authorities.
     * @return a list of all the authorities.
     */
    @Transactional(readOnly = true)
    public List<String> getAuthorities() {
        List<String> list = new ArrayList<>();
        for (Authority authority : authorityRepository.findAll()) {
            String name = authority.getName();
            list.add(name);
        }
        return list;
    }
}
