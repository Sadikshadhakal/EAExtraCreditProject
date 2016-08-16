package mum.edu.cs544.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Beneficiary {

	@Id @GeneratedValue
	private int beneficiaryId;
	private String beneficiaryName;
	private String beneficiaryDescription;
	@Lob
	private byte[]picture;
	
	@ManyToMany(mappedBy="beneficiaries")
	private List<Project> projectList = new ArrayList<Project>();
	
	public Beneficiary(){
		
	}

	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBeneficiaryDescription() {
		return beneficiaryDescription;
	}

	public void setBeneficiaryDescription(String beneficiaryDescription) {
		this.beneficiaryDescription = beneficiaryDescription;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficiaryDescription == null) ? 0 : beneficiaryDescription.hashCode());
		result = prime * result + beneficiaryId;
		result = prime * result + ((beneficiaryName == null) ? 0 : beneficiaryName.hashCode());
		result = prime * result + Arrays.hashCode(picture);
		result = prime * result + ((projectList == null) ? 0 : projectList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beneficiary other = (Beneficiary) obj;
		if (beneficiaryDescription == null) {
			if (other.beneficiaryDescription != null)
				return false;
		} else if (!beneficiaryDescription.equals(other.beneficiaryDescription))
			return false;
		if (beneficiaryId != other.beneficiaryId)
			return false;
		if (beneficiaryName == null) {
			if (other.beneficiaryName != null)
				return false;
		} else if (!beneficiaryName.equals(other.beneficiaryName))
			return false;
		if (!Arrays.equals(picture, other.picture))
			return false;
		if (projectList == null) {
			if (other.projectList != null)
				return false;
		} else if (!projectList.equals(other.projectList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Beneficiary [beneficiaryId=" + beneficiaryId + ", beneficiaryName=" + beneficiaryName
				+ ", beneficiaryDescription=" + beneficiaryDescription + ", picture=" + Arrays.toString(picture)
				+ ", projectList=" + projectList + "]";
	}

}
