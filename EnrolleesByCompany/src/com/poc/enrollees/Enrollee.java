package com.poc.enrollees;

import java.util.Objects;

public  class Enrollee implements Comparable<Enrollee> {
    private String userId;
    private String firstAndLastName;
    private Integer version;
    private String insuranceCompany;

    public Enrollee(String userId, String firstAndLastName, Integer version, String insuranceCompany) {
        this.userId = userId;
        this.firstAndLastName = firstAndLastName;
        this.version = version;
        this.insuranceCompany = insuranceCompany;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public Integer getVersion() {
        return version;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    @Override
    public int compareTo(Enrollee o) {
        int result = this.getFirstAndLastName().compareTo(o.getFirstAndLastName());
        if (result == 0) {
            result = this.getVersion().compareTo(o.getVersion());
        }
        return result ;
    }

    @Override
    public String toString() {
        return userId + "," + firstAndLastName + ","  + version + "," + insuranceCompany;
    }

	@Override
	public int hashCode() {
		return Objects.hash(firstAndLastName, insuranceCompany, userId, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollee other = (Enrollee) obj;
		return Objects.equals(firstAndLastName, other.firstAndLastName)
				&& Objects.equals(insuranceCompany, other.insuranceCompany) && Objects.equals(userId, other.userId)
				&& Objects.equals(version, other.version);
	}
    
    
    
}
