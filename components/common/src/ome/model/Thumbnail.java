package ome.model;

import java.util.*;




/**
 * Thumbnail generated by hbm2java
 */
public class
Thumbnail 
implements java.io.Serializable ,
ome.api.OMEModel,
ome.util.Filterable {

    // Fields    

     private Integer attributeId;
     private String path;
     private String mimeType;
     private Repository repository;
     private Image image;
     private ModuleExecution moduleExecution;


    // Constructors

    /** default constructor */
    public Thumbnail() {
    }
    
    /** constructor with id */
    public Thumbnail(Integer attributeId) {
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
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 
     */
    public String getMimeType() {
        return this.mimeType;
    }
    
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * 
     */
    public Repository getRepository() {
        return this.repository;
    }
    
    public void setRepository(Repository repository) {
        this.repository = repository;
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

	  // Visiting: Path ------------------------------------------
	  String _Path = null;
	  try {
	     _Path = getPath();
	  } catch (Exception e) {
		 setPath(null);
	  }

	  setPath((String) filter.filter(PATH,_Path)); 

	  // Visiting: MimeType ------------------------------------------
	  String _MimeType = null;
	  try {
	     _MimeType = getMimeType();
	  } catch (Exception e) {
		 setMimeType(null);
	  }

	  setMimeType((String) filter.filter(MIMETYPE,_MimeType)); 

	  // Visiting: Repository ------------------------------------------
	  Repository _Repository = null;
	  try {
	     _Repository = getRepository();
	  } catch (Exception e) {
		 setRepository(null);
	  }

	  setRepository((Repository) filter.filter(REPOSITORY,_Repository)); 

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
	return "Thumbnail"+(attributeId==null ? ":Hash_"+this.hashCode() : ":Id_"+attributeId);
  }
  
  // FIELD-FIELDS
  
	public final static String ATTRIBUTEID = "Thumbnail_AttributeId";
	public final static String PATH = "Thumbnail_Path";
	public final static String MIMETYPE = "Thumbnail_MimeType";
	public final static String REPOSITORY = "Thumbnail_Repository";
	public final static String IMAGE = "Thumbnail_Image";
	public final static String MODULEEXECUTION = "Thumbnail_ModuleExecution";
 	public final static Set FIELDS = new HashSet();
	static {
	   FIELDS.add(ATTRIBUTEID);
	   FIELDS.add(PATH);
	   FIELDS.add(MIMETYPE);
	   FIELDS.add(REPOSITORY);
	   FIELDS.add(IMAGE);
	   FIELDS.add(MODULEEXECUTION);
 	}


}
