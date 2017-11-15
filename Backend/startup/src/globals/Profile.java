package globals;

public class Profile {
	public String id;
	public String name;
	public String email;
	public String phone;
	public String gender;
	public String city;
	public String country;
	public String fb;
	public String pic;
	public String education_id;
	public String school;
	public String coaching;
	public String college;
	public String branch;
	public String profession;
	public String board;
	public String mains;
	public String advance;
	public String pmt;
	public String percentage;
	public String other;

	// Constructor
	public Profile() {

	}

	// Copy Constructor
	public Profile(Profile p) {
		this.id = p.id;
		this.name = p.name;
		this.phone = p.phone;
		this.email = p.email;
		this.gender = p.gender;
		this.city = p.city;
		this.country = p.country;
		this.fb = p.fb;
		this.pic = p.pic;
		this.education_id = p.education_id;
		this.school = p.school;
		this.coaching = p.coaching;
		this.college = p.college;
		this.branch = p.branch;
		this.profession = p.profession;
		this.board = p.board;
		this.mains = p.mains;
		this.advance = p.advance;
		this.pmt = p.pmt;
		this.percentage = p.percentage;
		this.other = p.other;
	}
}
