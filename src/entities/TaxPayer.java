package entities;

public class TaxPayer {
	
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	public TaxPayer() {
	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		super();
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getSservicesIncome() {
		return servicesIncome;
	}

	public void setSservicesIncome(double sservicesIncome) {
		this.servicesIncome = sservicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		double salaryPerMonth = salaryIncome / 12.0;
		double salaryTax=0.0;
		
		if(salaryPerMonth < 3000.0) {
			System.out.println("Contribuinte isento de declaração");
		}else if (salaryPerMonth < 5000.0) {
			salaryTax = salaryIncome * (10.0 / 100.0);
		}else {
			salaryTax = salaryIncome * (20.0 / 100.0);
		}
		
		return salaryTax;
	}
	
	public double servicesTax() {
		return servicesIncome * (15.0 / 100.0);
	}
	
	public double capitalTax() {
		return capitalIncome * (20.0 / 100.0);
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double allRebatableCost = healthSpending + educationSpending;
		double maxRebatable = grossTax() * (30.0 / 100.0);
		if(allRebatableCost < maxRebatable) {
			return allRebatableCost;
		}else {
			return maxRebatable;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
	@Override
	public String toString() {
		return "Imposto bruto total: " 
				+ String.format("%.2f\n", grossTax())
				+ "Abatimento: "
				+ String.format("%.2f\n", taxRebate())
				+ "Imposto devido: "
				+ String.format("%.2f\n", netTax());
	}
}
