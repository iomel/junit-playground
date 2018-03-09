package users;


import users.exception.BadRequestException;
import users.exception.InternalServerException;
import users.exception.UserNotFoundException;

public class UserRepository {
    private User[] users = new User[10];

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames()
    {
        int count = 0;
        for(User user : getUsers())
            if(user != null)
                count++;

        String[] nameList = new String[count];
        count = 0;

        for(User user : getUsers())
            if(user != null) {
                nameList[count] = user.getName();
                count++;
            }
        return nameList;
    }

    public long[] getUserIds()
    {
        int count = 0;
        for(User user : getUsers())
            if(user != null)
                count++;

        long[] idList = new long[count];
        count = 0;

        for(User user : getUsers())
            if(user != null) {
                idList[count] = user.getId();
                count++;
            }
        return idList;
    }

    public String getUserNameById(long id)
    {
        for (User user : getUsers())
        {
            if (user == null)
                continue;
            else if (user.getId() == id)
                return user.getName();
        }
        return null;
    }

    public User getUserByName(String name) throws BadRequestException
    {
        if ( name == null)
            throw new BadRequestException("Can't get user with null name");

        for(User user : getUsers())
            if (user != null && user.getName() == name)
                return user;
        return null;
    }

    public User getUserBySessionId(String sessionId) throws Exception
    {
        if (sessionId == null)
            throw new BadRequestException("Can't get user with null session id");

        for (User user : getUsers())
            if (user != null && user.getSessionId() == sessionId)
                return user;
        throw new UserNotFoundException("User with session id: " + sessionId + " not found");
    }

    public User findById(long id) throws UserNotFoundException {
        System.out.println("CALL: findById ");
        for(User user : getUsers())
            if (user != null && user.getId() == id)
                return user;
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public User save(User user) throws Exception
    {
        System.out.println("CALL: save ");

        if(user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e)
        {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        for (int i = 0; i < getUsers().length; i++)
        {
            if(getUsers()[i] == null) {
                getUsers()[i] = user;
                return getUsers()[i];
            }
        }
        throw new InternalServerException("Not enough space to save user with id:" + user.getId() );
    }

    public User update(User user) throws Exception
    {
        if(user == null)
            throw new BadRequestException("Can't save null user");

        findById(user.getId());

        for (int i = 0; i < getUsers().length; i++)
            if(getUsers()[i] != null && getUsers()[i].getId() == user.getId()) {
                getUsers()[i] = user;
                    return getUsers()[i];
                }
        throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws Exception
    {
        findById(id);
        for (int i = 0; i < getUsers().length; i++)
            if(getUsers()[i] != null && getUsers()[i].getId() == id) {
                getUsers()[i] = null;
                break;
            }
    }
}