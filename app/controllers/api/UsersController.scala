package controllers.api

import java.util.UUID

/**
  * A controller to collect all API methods related to users.
  */
class UsersController {

  /**
    * Finds the users matching the given filters.
    *
    * @param search The returned array will only contain users whose name or email address contains search.
    *               If search is null, the users are neitehr filtered by name nor by email address.
    * @param role   The returned array will only contain users whose role matches the given role. If role is null, the
    *               users are not filtered by role.
    * @return the users matching the given filter parameters.
    * @todo Implement controller method
    */
  def userList(search: String, role: String) = play.mvc.Results.TODO

  /**
    *
    * @param id
    * @return
    * @todo Add documentationt
    * @todo Implement controller method
    */
  def updateUser(id: UUID) = play.mvc.Results.TODO

}