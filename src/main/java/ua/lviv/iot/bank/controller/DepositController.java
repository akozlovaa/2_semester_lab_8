package ua.lviv.iot.bank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.bank.business.DepositService;

import ua.lviv.iot.bank.model.Deposit;

@RequestMapping("/deposits")
@RestController
public class DepositController {

  @Autowired
  private DepositService depositService;

  @GetMapping
  public List<Deposit> getDeposits() {
    return depositService.getDeposits();
  }

  @GetMapping(path = {"/{id}"})
  public ResponseEntity<Deposit> getDeposit(final @PathVariable("id") Integer depositId) {

  Deposit deposit;

  ResponseEntity<Deposit> status = (deposit = depositService.getDeposit(depositId)) == null
      ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
      : new ResponseEntity<>(deposit, HttpStatus.OK);
      return status;
  }

  @PostMapping
  public Deposit createDeposit(final @RequestBody Deposit deposit) {
    return depositService.createDeposit(deposit);
  }

  @DeleteMapping(path = {"/{id}"})
  public ResponseEntity<Deposit> deleteDeposit(@PathVariable("id") Integer depositId) {
    HttpStatus status = depositService.deleteDeposit(depositId) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return ResponseEntity.status(status).build();
  }

  @PutMapping(path = {"/{id}"})
  public ResponseEntity<Deposit> updateDeposit(final @PathVariable("id") Integer depositId,
    final @RequestBody Deposit deposit) {
    deposit.setId(depositId);
    Deposit oldDeposit = depositService.updateDeposit(depositId, deposit);
    ResponseEntity<Deposit> status = oldDeposit == null
        ? new ResponseEntity<Deposit>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<Deposit>(oldDeposit, HttpStatus.OK);
    return status;
  }
}
