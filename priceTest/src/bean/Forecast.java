package bean;
//房价预测实体类
public class Forecast {
	private String f_city;//城市
	private String f_district;//地区
	private float area;//面积
	private String chaoxiang;//朝向
	private String zhuangtai;//装修状态
	private int height;//楼层
	public String getFcity() {
		return f_city;
	}
	public void setFcity(String f_city) {
		this.f_city = f_city;
	}
	public String getFdistrict() {
		return f_district;
	}
	public void setFdistrict(String f_district) {
		this.f_district = f_district;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public String getChaoxiang() {
		return chaoxiang;
	}
	public void setChaoxiang(String chaoxiang) {
		this.chaoxiang = chaoxiang;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
