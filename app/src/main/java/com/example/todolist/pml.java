package com.example.todolist;

class pml {

    /*
    Create two strings to call from toDo.json
     */

    private String title;
    private String tdl;


    /*
    Generate Constructors
     */

    /**
     * @param title
     * @param tdl
     */
    public pml(String title, String tdl) {
        this.title = title;
        this.tdl = tdl;

    }

    public pml() {
    }
    /*

    Generate Getters and Setters
    */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTdl() {
        return tdl;
    }

    public void setTdl(String tdl) {
        this.tdl = tdl;
    }
}
