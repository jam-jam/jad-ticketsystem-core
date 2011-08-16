package be.intecbrussel.jad.model.data;

import  be.intecbrussel.jad.model.entities.Account;

/**
 *
 * @author ZI
 */

public class AccountDAO extends GenericDAO<Account> {

    public AccountDAO() {
        super(Account.class);
    }
}
