package users;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    //----- TASK 2 ---------------------

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames()
    {
        if (users == null)
            return null;
        int count = 0;
        for(User user : users)
            if(user != null)
                count++;

        String[] nameList = new String[count];
        count = 0;

        for(User user : users)
            if(user != null) {
                nameList[count] = user.getName();
                count++;
            }

        return nameList;
    }

    public long[] getUserIds()
    {
        if (users == null)
            return null;
        int count = 0;
        for(User user : users)
            if(user != null)
                count++;

        long[] idList = new long[count];
        count = 0;

        for(User user : users)
            if(user != null) {
                idList[count] = user.getId();
                count++;
            }

        return idList;
    }

    public String getUserNameById(long id)
    {
        if (users == null)
            return null;

        for (User user : users)
        {
            if (user == null)
                continue;
            else if (user.getId() == id)
                return user.getName();

        }
        return null;
    }

    // task 3 methods

    public User getUserByName(String name)
    {
        if (users == null ||  name == null)
            return null;

        for(User user : users) {
            if (user == null)
                continue;
            if (user.getName() == name)
                return user;
        }
        return null;
    }


    public User getUserBySessionId(String sessionId)
    {
            if (users == null || sessionId == null)
                return null;

            for (User user : users) {
                if (user == null)
                    continue;

                if (user.getSessionId() == sessionId)
                    return user;
            }
            return null;
    }

    // --------- Task 4 ----------

    public User findById(long id)
    {
        if (users == null)
            return null;

        for(User user : users) {
            if (user == null)
                continue;

            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public User save(User user)
    {
        if (users == null)
            return null;
        if(user == null)
            return null;

        if (findById(user.getId()) != null)
            return null;

        for (int i = 0; i < users.length; i++)
        {
            if(users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }

    // ------ Task 5 -------

    public User update(User user)
    {
        if (users == null)
            return null;
        if(user == null)
            return null;

        if (findById(user.getId()) == null)
            return null;


        for (int i = 0; i < users.length; i++)
        {
            if(users[i] != null) {
                if(users[i].getId() == user.getId());
                {
                    users[i] = user;
                    return users[i];
                }
            }
        }
        return null;

    }

    public void delete(long id)
    {
        if(findById(id) != null)
            for (int i = 0; i < users.length; i++)
                if(users[i] != null)
                    if(users[i].getId() == id)
                        users[i] = null;

    }
}