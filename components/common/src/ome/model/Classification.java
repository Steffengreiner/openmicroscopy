package ome.model;

import java.util.*;




/**
 * Classification generated by hbm2java
 */
public class
Classification 
implements java.io.Serializable ,
ome.api.OMEModel,
ome.util.Filterable {

    // Fields    

     private Integer attributeId;
     private Float confidence;
     private Boolean valid;
     private Category category;
     private Image image;
     private ModuleExecution moduleExecution;


    // Constructors

    /** default constructor */
    public Classification() {
    }
    
    /** constructor with id */
    public Classification(Integer attributeId) {
        this.attributeId = attributeId;
    }
   
    
    

    // Property accessors

    /**
     * 
     */
    public Integer getAttributeId() {
        return this.attributeId;
    }
    
    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * 
     */
    public Float getConfidence() {
        return this.confidence;
    }
    
    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }

    /**
     * 
     */
    public Boolean getValid() {
        return this.valid;
    }
    
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * 
     */
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * 
     */
    public Image getImage() {
        return this.image;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * 
     */
    public ModuleExecution getModuleExecution() {
        return this.moduleExecution;
    }
    
    public void setModuleExecution(ModuleExecution moduleExecution) {
        this.moduleExecution = moduleExecution;
    }






  public boolean acceptFilter(ome.util.Filter filter){


	  // Visiting: AttributeId ------------------------------------------
	  Integer _AttributeId = null;
	  try {
	     _AttributeId = getAttributeId();
	  } catch (Exception e) {
		 setAttributeId(null);
	  }

	  setAttributeId((Integer) filter.filter(ATTRIBUTEID,_AttributeId)); 

	  // Visiting: Confidence ------------------------------------------
	  Float _Confidence = null;
	  try {
	     _Confidence = getConfidence();
	  } catch (Exception e) {
		 setConfidence(null);
	  }

	  setConfidence((Float) filter.filter(CONFIDENCE,_Confidence)); 

	  // Visiting: Valid ------------------------------------------
	  Boolean _Valid = null;
	  try {
	     _Valid = getValid();
	  } catch (Exception e) {
		 setValid(null);
	  }

	  setValid((Boolean) filter.filter(VALID,_Valid)); 

	  // Visiting: Category ------------------------------------------
	  Category _Category = null;
	  try {
	     _Category = getCategory();
	  } catch (Exception e) {
		 setCategory(null);
	  }

	  setCategory((Category) filter.filter(CATEGORY,_Category)); 

	  // Visiting: Image ------------------------------------------
	  Image _Image = null;
	  try {
	     _Image = getImage();
	  } catch (Exception e) {
		 setImage(null);
	  }

	  setImage((Image) filter.filter(IMAGE,_Image)); 

	  // Visiting: ModuleExecution ------------------------------------------
	  ModuleExecution _ModuleExecution = null;
	  try {
	     _ModuleExecution = getModuleExecution();
	  } catch (Exception e) {
		 setModuleExecution(null);
	  }

	  setModuleExecution((ModuleExecution) filter.filter(MODULEEXECUTION,_ModuleExecution)); 
   	 return true;
  }
  
  public String toString(){
	return "Classification"+(attributeId==null ? ":Hash_"+this.hashCode() : ":Id_"+attributeId);
  }
  
  // FIELD-FIELDS
  
	public final static String ATTRIBUTEID = "Classification_AttributeId";
	public final static String CONFIDENCE = "Classification_Confidence";
	public final static String VALID = "Classification_Valid";
	public final static String CATEGORY = "Classification_Category";
	public final static String IMAGE = "Classification_Image";
	public final static String MODULEEXECUTION = "Classification_ModuleExecution";
 	public final static Set FIELDS = new HashSet();
	static {
	   FIELDS.add(ATTRIBUTEID);
	   FIELDS.add(CONFIDENCE);
	   FIELDS.add(VALID);
	   FIELDS.add(CATEGORY);
	   FIELDS.add(IMAGE);
	   FIELDS.add(MODULEEXECUTION);
 	}


}
