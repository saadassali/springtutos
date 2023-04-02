package ma.cigma.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.cigma.springsecurity.service.model.User;


/**
 * Deux types de sessions :
 * 
 *  1- Session orientée transaction (par défaut).
 *  2- Extended context (la session reste ouverte).
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String userName);
}
