
angular.module('uiApp').service('AdminFactory', function(){


    var users = [

        {
            firstName: "Lamija",
            lastName: "Halvadzija",
            email: "lh@lh.com",
            role: "supervisor"
        },
        {
            firstName: "Nitish",
            lastName: "Patkar",
            email: "np@np.com",
            role: "supervisor"
        },
        {
            firstName: "Venkatesh",
            lastName: "Penchala",
            email: "vp@vp.com",
            role: "admin"
        },
        {
            firstName: "Usman",
            lastName: "Sherwani",
            email: "us@us.com",
            role: "student"
        },
        {
            firstName: "Jan",
            lastName: "Lippert",
            email: "jp@jp.com",
            role: "supervisor"
        }

    ];

    var roles = ["Admin", "Student", "Supervisor"];



    return {
        getUsers: function() {
            return users;
        },

        getRoles: function(){

            return roles;

        }
    };

});