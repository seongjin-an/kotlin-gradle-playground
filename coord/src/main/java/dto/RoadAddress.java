package dto;

public class RoadAddress {
	private String address_name;
	private String building_name;
	private String main_building_no;
	private String region_1depth_name;
	private String region_2depth_name;
	private String region_3depth_name;
	private String road_name;
	private String sub_building_no;
	private String underground_yn;
	private String x;
	private String y;
	private String zone_no;

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	public String getMain_building_no() {
		return main_building_no;
	}

	public void setMain_building_no(String main_building_no) {
		this.main_building_no = main_building_no;
	}

	public String getRegion_1depth_name() {
		return region_1depth_name;
	}

	public void setRegion_1depth_name(String region_1depth_name) {
		this.region_1depth_name = region_1depth_name;
	}

	public String getRegion_2depth_name() {
		return region_2depth_name;
	}

	public void setRegion_2depth_name(String region_2depth_name) {
		this.region_2depth_name = region_2depth_name;
	}

	public String getRegion_3depth_name() {
		return region_3depth_name;
	}

	public void setRegion_3depth_name(String region_3depth_name) {
		this.region_3depth_name = region_3depth_name;
	}

	public String getRoad_name() {
		return road_name;
	}

	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}

	public String getSub_building_no() {
		return sub_building_no;
	}

	public void setSub_building_no(String sub_building_no) {
		this.sub_building_no = sub_building_no;
	}

	public String getUnderground_yn() {
		return underground_yn;
	}

	public void setUnderground_yn(String underground_yn) {
		this.underground_yn = underground_yn;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getZone_no() {
		return zone_no;
	}

	public void setZone_no(String zone_no) {
		this.zone_no = zone_no;
	}

	@Override
	public String toString() {
		return "RoadAddress{" +
				"address_name='" + address_name + '\'' +
				", building_name='" + building_name + '\'' +
				", main_building_no='" + main_building_no + '\'' +
				", region_1depth_name='" + region_1depth_name + '\'' +
				", region_2depth_name='" + region_2depth_name + '\'' +
				", region_3depth_name='" + region_3depth_name + '\'' +
				", road_name='" + road_name + '\'' +
				", sub_building_no='" + sub_building_no + '\'' +
				", underground_yn='" + underground_yn + '\'' +
				", x='" + x + '\'' +
				", y='" + y + '\'' +
				", zone_no='" + zone_no + '\'' +
				'}';
	}
}
