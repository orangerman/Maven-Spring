package repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository implements UserRepository {
    public void save() {
        System.out.println("UserJdbcRepository save...");

    }
}
