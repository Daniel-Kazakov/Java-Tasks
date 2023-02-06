public class Contact implements Comparable<Contact>{

    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
	public int compareTo(Contact contact) {
		return this.getName().compareTo(contact.getName());
	}
}
