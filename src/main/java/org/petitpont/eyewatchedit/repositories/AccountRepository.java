package org.petitpont.eyewatchedit.repositories;

import org.petitpont.eyewatchedit.models.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByUsername(String username);

}
