package app.domain.dtos.branches;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "branches")
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchWrapperXmlDto implements Serializable {

	@XmlElement(name = "branch")
	private List<BranchXmlDto> branchXmlDtos;

	public BranchWrapperXmlDto() {
		super();
	}

	public List<BranchXmlDto> getBranchXmlDtos() {
		return branchXmlDtos;
	}

	public void setBranchXmlDtos(List<BranchXmlDto> branchXmlDtos) {
		this.branchXmlDtos = branchXmlDtos;
	}

}
