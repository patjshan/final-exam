package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtSaveEachMonth;
	@FXML
	private TextField txtAnnualReturnWork;
	@FXML
	private TextField txtAmountToSve;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		this.txtAmountToSve.clear();
		this.txtAnnualReturnRetired.clear();
		this.txtAnnualReturnWork.clear();
		this.txtMonthlySSI.clear();
		this.txtRequiredIncome.clear();
		this.txtSaveEachMonth.clear();
		this.txtYearsRetired.clear();
		this.txtYearsToWork.clear();
		
		//	TODO: Clear all the text inputs
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		try {
			Integer.parseInt(this.txtYearsToWork.getText());
			Integer.parseInt(this.txtYearsRetired.getText());
			Double.parseDouble(this.txtAnnualReturnRetired.getText());
			Double.parseDouble(this.txtAnnualReturnWork.getText());
			Double.parseDouble(this.txtMonthlySSI.getText());
			Double.parseDouble(this.txtRequiredIncome.getText());
			}
		catch (Exception e) {
			this.txtAmountToSve.setText("Please only enter numbers in the calculator");
		}
		int yearstowork = Integer.parseInt(this.txtYearsToWork.getText());
		int yearstoretire = Integer.parseInt(this.txtYearsRetired.getText());
		
		double AnnualReturnRetired = Double.parseDouble(this.txtAnnualReturnRetired.getText());
		double AnnualReturnWork = Double.parseDouble(this.txtAnnualReturnWork.getText());
		double MonthlySSI = Double.parseDouble(this.txtMonthlySSI.getText());
		double Requiredincome = Double.parseDouble(this.txtRequiredIncome.getText());

		Retirement retire = new Retirement(yearstowork, AnnualReturnWork, yearstoretire, AnnualReturnRetired, Requiredincome, MonthlySSI);
		
		double saveeachmonth = retire.AmountToSave();
		double amount2save = retire.TotalAmountSaved();
		
		this.txtSaveEachMonth.setText( ( Double.toString(saveeachmonth)));
		this.txtAmountToSve.setText(Double.toString(amount2save));
	}
	
}




