package ome.model;

import java.util.*;




/**
 * ImageAnnotation generated by hbm2java
 */
public class
ImageAnnotation 
implements java.io.Serializable ,
ome.api.OMEModel,
ome.util.Filterable {

    // Fields    

     private Integer attributeId;
     private Integer theT;
     private String content;
     private Integer theC;
     private Integer theZ;
     private Boolean valid;
     private Image image;
     private ModuleExecution moduleExecution;


    // Constructors

    /** default constructor */
    public ImageAnnotation() {
    }
    
    /** constructor with id */
    public ImageAnnotation(Integer attributeId) {
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
    public Integer getTheT() {
        return this.theT;
    }
    
    public void setTheT(Integer theT) {
        this.theT = theT;
    }

    /**
     * 
     */
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     */
    public Integer getTheC() {
        return this.theC;
    }
    
    public void setTheC(Integer theC) {
        this.theC = theC;
    }

    /**
     * 
     */
    public Integer getTheZ() {
        return this.theZ;
    }
    
    public void setTheZ(Integer theZ) {
        this.theZ = theZ;
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

	  // Visiting: TheT ------------------------------------------
	  Integer _TheT = null;
	  try {
	     _TheT = getTheT();
	  } catch (Exception e) {
		 setTheT(null);
	  }

	  setTheT((Integer) filter.filter(THET,_TheT)); 

	  // Visiting: Content ------------------------------------------
	  String _Content = null;
	  try {
	     _Content = getContent();
	  } catch (Exception e) {
		 setContent(null);
	  }

	  setContent((String) filter.filter(CONTENT,_Content)); 

	  // Visiting: TheC ------------------------------------------
	  Integer _TheC = null;
	  try {
	     _TheC = getTheC();
	  } catch (Exception e) {
		 setTheC(null);
	  }

	  setTheC((Integer) filter.filter(THEC,_TheC)); 

	  // Visiting: TheZ ------------------------------------------
	  Integer _TheZ = null;
	  try {
	     _TheZ = getTheZ();
	  } catch (Exception e) {
		 setTheZ(null);
	  }

	  setTheZ((Integer) filter.filter(THEZ,_TheZ)); 

	  // Visiting: Valid ------------------------------------------
	  Boolean _Valid = null;
	  try {
	     _Valid = getValid();
	  } catch (Exception e) {
		 setValid(null);
	  }

	  setValid((Boolean) filter.filter(VALID,_Valid)); 

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
	return "ImageAnnotation"+(attributeId==null ? ":Hash_"+this.hashCode() : ":Id_"+attributeId);
  }
  
  // FIELD-FIELDS
  
	public final static String ATTRIBUTEID = "ImageAnnotation_AttributeId";
	public final static String THET = "ImageAnnotation_TheT";
	public final static String CONTENT = "ImageAnnotation_Content";
	public final static String THEC = "ImageAnnotation_TheC";
	public final static String THEZ = "ImageAnnotation_TheZ";
	public final static String VALID = "ImageAnnotation_Valid";
	public final static String IMAGE = "ImageAnnotation_Image";
	public final static String MODULEEXECUTION = "ImageAnnotation_ModuleExecution";
 	public final static Set FIELDS = new HashSet();
	static {
	   FIELDS.add(ATTRIBUTEID);
	   FIELDS.add(THET);
	   FIELDS.add(CONTENT);
	   FIELDS.add(THEC);
	   FIELDS.add(THEZ);
	   FIELDS.add(VALID);
	   FIELDS.add(IMAGE);
	   FIELDS.add(MODULEEXECUTION);
 	}


}
