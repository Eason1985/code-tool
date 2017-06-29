package com.web.common;

public class ForeignKeyProperty {
	
		private String propertyName;
		
		private Class<? extends Object> foreignEntityClass ;
		
		
		private String foreignEntityKeyProperty ; 
		
		private String foreignEntityValueProperty ;
		
		
		
		
		public ForeignKeyProperty(String propertyName,
				Class<? extends Object> foreignEntityClass,
				String foreignEntityKeyProperty,
				String foreignEntityValueProperty) {
			super();
			this.propertyName = propertyName;
			this.foreignEntityClass=foreignEntityClass ; 
			this.foreignEntityKeyProperty = foreignEntityKeyProperty ; 
			this.foreignEntityValueProperty = foreignEntityValueProperty ; 
		}
		public String getPropertyName() {
			return propertyName;
		}
		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}
		public Class<? extends Object> getForeignEntityClass() {
			return foreignEntityClass;
		}
		public void setForeignEntityClass(Class<? extends Object> foreignEntityClass) {
			this.foreignEntityClass = foreignEntityClass;
		}
		public String getForeignEntityKeyProperty() {
			return foreignEntityKeyProperty;
		}
		public void setForeignEntityKeyProperty(String foreignEntityKeyProperty) {
			this.foreignEntityKeyProperty = foreignEntityKeyProperty;
		}
		public String getForeignEntityValueProperty() {
			return foreignEntityValueProperty;
		}
		public void setForeignEntityValueProperty(String foreignEntityValueProperty) {
			this.foreignEntityValueProperty = foreignEntityValueProperty;
		}
		 
		
		
		
}
