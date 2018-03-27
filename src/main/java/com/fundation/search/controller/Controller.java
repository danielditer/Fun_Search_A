package com.fundation.search.controller;

public class Controller {
    //private View view;
    //private Model model;
    /**
     * Method to initialize view.
     */
    public void initViewModel() {
        //view = new View();
        //model = new Model();
    }

    public void getFieldsFromView() {
        //name = JTextFieldName.getText();
        //path = JTextFieldPath.getText();
        //Validator validator = new Validator();
        /**
         * if (validator.validateName(name) && validator.validatePath(name)) {
         *     setSearchCriteria(name, path);
         * }
         */

    }

    public void setSearchCriteria(String name, String path) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setName("filename");
        criteria.setPath("c:\\Users\\");
        //model.setCriteria(criteria);
        //model.search();
    }
}
