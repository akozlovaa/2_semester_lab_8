package ua.lviv.iot.bank.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.bank.dataaccess.DepositRepository;
import ua.lviv.iot.bank.model.Deposit;


@Service
public class DepositService {
	
  @Autowired
  private DepositRepository depositRepository;

  public List<Deposit> getDeposits() {
    return depositRepository.findAll();
  }

  public Deposit getDeposit(Integer id) {
    if (depositRepository.existsById(id)) {
      return depositRepository.findById(id).get();
    } else {
      return null;
    }
  }

  public Deposit createDeposit(Deposit deposit) {
    return depositRepository.save(deposit);
  }

  public boolean deleteDeposit(Integer id) {
    if (depositRepository.existsById(id)) {
      depositRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  public Deposit updateDeposit(Integer id, Deposit deposit) {
    if (depositRepository.existsById(id)) {
      Deposit previousDeposit = depositRepository.findById(id).get();
      depositRepository.save(deposit);
      return previousDeposit;
    } else {
      return null;
    }
  }
}
