package ua.lviv.iot.bank.model;

import javax.persistence.Entity;

@Entity
public class Deposit extends AbstractBankService {
  private double depositAmountInUsD;

  @Override
  public String giveHeaders() {
    return super.giveHeaders() + "," + "depositAmountInUsD";
  }

  @Override
  public String toCSV() {
    return super.toCSV() + "," + depositAmountInUsD;
  }

  public double getDepositAmountInUsD() {
    return depositAmountInUsD;
  }

  public void setDepositAmountInUsD(double depositAmountInUsD) {
    this.depositAmountInUsD = depositAmountInUsD;
  }

  public Deposit(String bankName, int issueYear, String customerName, double interestRateInPercents, String planName,
               double maintenanceFeeInUsD, ServiceType serviceType, double depositAmountInUsD) {
    super(bankName, issueYear, customerName, interestRateInPercents, planName, maintenanceFeeInUsD, serviceType);
    this.depositAmountInUsD = depositAmountInUsD;
  }

  public Deposit() {

  }
}
