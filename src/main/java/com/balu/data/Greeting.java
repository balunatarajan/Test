package com.balu.data;

	
	public class Greeting {
		
		public Greeting(long id, String content) {
	        this.id = id;
	        this.content = content;
	    }
	    public long getId() {
			return id;
		}
		public String getContent() {
			return content;
		}
		private final long id;
	    private final String content;
}