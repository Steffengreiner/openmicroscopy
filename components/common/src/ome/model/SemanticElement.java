package ome.model;

import java.util.*;




/**
 * SemanticElement generated by hbm2java
 */
public class
SemanticElement 
implements java.io.Serializable ,
ome.api.OMEModel,
ome.util.Filterable {

    // Fields    

     private Integer semanticElementId;
     private String name;
     private String description;
     private SemanticType semanticType;


    // Constructors

    /** default constructor */
    public SemanticElement() {
    }
    
    /** constructor with id */
    public SemanticElement(Integer semanticElementId) {
        this.semanticElementId = semanticElementId;
    }
   
    
    

    // Property accessors

    /**
     * 
     */
    public Integer getSemanticElementId() {
        return this.semanticElementId;
    }
    
    public void setSemanticElementId(Integer semanticElementId) {
        this.semanticElementId = semanticElementId;
    }

    /**
     * 
     */
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     */
    public SemanticType getSemanticType() {
        return this.semanticType;
    }
    
    public void setSemanticType(SemanticType semanticType) {
        this.semanticType = semanticType;
    }






  public boolean acceptFilter(ome.util.Filter filter){


	  // Visiting: SemanticElementId ------------------------------------------
	  Integer _SemanticElementId = null;
	  try {
	     _SemanticElementId = getSemanticElementId();
	  } catch (Exception e) {
		 setSemanticElementId(null);
	  }

	  setSemanticElementId((Integer) filter.filter(SEMANTICELEMENTID,_SemanticElementId)); 

	  // Visiting: Name ------------------------------------------
	  String _Name = null;
	  try {
	     _Name = getName();
	  } catch (Exception e) {
		 setName(null);
	  }

	  setName((String) filter.filter(NAME,_Name)); 

	  // Visiting: Description ------------------------------------------
	  String _Description = null;
	  try {
	     _Description = getDescription();
	  } catch (Exception e) {
		 setDescription(null);
	  }

	  setDescription((String) filter.filter(DESCRIPTION,_Description)); 

	  // Visiting: SemanticType ------------------------------------------
	  SemanticType _SemanticType = null;
	  try {
	     _SemanticType = getSemanticType();
	  } catch (Exception e) {
		 setSemanticType(null);
	  }

	  setSemanticType((SemanticType) filter.filter(SEMANTICTYPE,_SemanticType)); 
   	 return true;
  }
  
  public String toString(){
	return "SemanticElement"+(semanticElementId==null ? ":Hash_"+this.hashCode() : ":Id_"+semanticElementId);
  }
  
  // FIELD-FIELDS
  
	public final static String SEMANTICELEMENTID = "SemanticElement_SemanticElementId";
	public final static String NAME = "SemanticElement_Name";
	public final static String DESCRIPTION = "SemanticElement_Description";
	public final static String SEMANTICTYPE = "SemanticElement_SemanticType";
 	public final static Set FIELDS = new HashSet();
	static {
	   FIELDS.add(SEMANTICELEMENTID);
	   FIELDS.add(NAME);
	   FIELDS.add(DESCRIPTION);
	   FIELDS.add(SEMANTICTYPE);
 	}


}
