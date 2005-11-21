package ome.model;

import java.util.*;




/**
 * ImageInfo generated by hbm2java
 */
public class
ImageInfo 
implements java.io.Serializable ,
ome.api.OMEModel,
ome.util.Filterable {

    // Fields    

     private Integer attributeId;
     private Image image;
     private Group group;
     private ModuleExecution moduleExecution;


    // Constructors

    /** default constructor */
    public ImageInfo() {
    }
    
    /** constructor with id */
    public ImageInfo(Integer attributeId) {
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
    public Image getImage() {
        return this.image;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * 
     */
    public Group getGroup() {
        return this.group;
    }
    
    public void setGroup(Group group) {
        this.group = group;
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

	  // Visiting: Image ------------------------------------------
	  Image _Image = null;
	  try {
	     _Image = getImage();
	  } catch (Exception e) {
		 setImage(null);
	  }

	  setImage((Image) filter.filter(IMAGE,_Image)); 

	  // Visiting: Group ------------------------------------------
	  Group _Group = null;
	  try {
	     _Group = getGroup();
	  } catch (Exception e) {
		 setGroup(null);
	  }

	  setGroup((Group) filter.filter(GROUP,_Group)); 

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
	return "ImageInfo"+(attributeId==null ? ":Hash_"+this.hashCode() : ":Id_"+attributeId);
  }
  
  // FIELD-FIELDS
  
	public final static String ATTRIBUTEID = "ImageInfo_AttributeId";
	public final static String IMAGE = "ImageInfo_Image";
	public final static String GROUP = "ImageInfo_Group";
	public final static String MODULEEXECUTION = "ImageInfo_ModuleExecution";
 	public final static Set FIELDS = new HashSet();
	static {
	   FIELDS.add(ATTRIBUTEID);
	   FIELDS.add(IMAGE);
	   FIELDS.add(GROUP);
	   FIELDS.add(MODULEEXECUTION);
 	}


}
