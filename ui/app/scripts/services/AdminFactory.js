
angular.module('uiApp').service('AdminFactory', function(){


    var users = [

        {
            firstName: "Lamija",
            lastName: "Halvadzija",
            email: "lh@lh.com",
            role: "Supervisor"
        },
        {
            firstName: "Nitish",
            lastName: "Patkar",
            email: "np@np.com",
            role: "Supervisor"
        },
        {
            firstName: "Venkatesh",
            lastName: "Penchala",
            email: "vp@vp.com",
            role: "Admin"
        },
        {
            firstName: "Usman",
            lastName: "Sherwani",
            email: "us@us.com",
            role: "Student"
        },
        {
            firstName: "Jan",
            lastName: "Lippert",
            email: "jp@jp.com",
            role: "Supervisor"
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
