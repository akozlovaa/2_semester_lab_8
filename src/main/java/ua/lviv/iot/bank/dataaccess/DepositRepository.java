package ua.lviv.iot.bank.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.bank.model.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer> {

}
