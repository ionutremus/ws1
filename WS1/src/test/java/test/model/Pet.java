package test.model;

/**
 * Created by john on 27/05/2015.
 */
public class Pet {
    private String name;
	private String status;
    private int id;
    private String[] photoUrls;

    public Pet(String status, String name) {
        this.status = status;
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

	public String[] getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
}
