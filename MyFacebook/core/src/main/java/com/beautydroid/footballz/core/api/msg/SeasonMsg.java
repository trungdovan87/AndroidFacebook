package com.beautydroid.footballz.core.api.msg;

public class SeasonMsg
{
    public class Links
    {
        private Fixtures fixtures;

        private Teams teams;

        private Self self;

        private LeagueTable leagueTable;

        public Fixtures getFixtures ()
        {
            return fixtures;
        }

        public void setFixtures (Fixtures fixtures)
        {
            this.fixtures = fixtures;
        }

        public Teams getTeams ()
        {
            return teams;
        }

        public void setTeams (Teams teams)
        {
            this.teams = teams;
        }

        public Self getSelf ()
        {
            return self;
        }

        public void setSelf (Self self)
        {
            this.self = self;
        }

        public LeagueTable getLeagueTable ()
        {
            return leagueTable;
        }

        public void setLeagueTable (LeagueTable leagueTable)
        {
            this.leagueTable = leagueTable;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [fixtures = "+fixtures+", teams = "+teams+", self = "+self+", leagueTable = "+leagueTable+"]";
        }
    }

    public class LeagueTable
    {
        private String href;

        public String getHref ()
        {
            return href;
        }

        public void setHref (String href)
        {
            this.href = href;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [href = "+href+"]";
        }
    }

    public class Fixtures
    {
        private String href;

        public String getHref ()
        {
            return href;
        }

        public void setHref (String href)
        {
            this.href = href;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [href = "+href+"]";
        }
    }


    public class Teams
    {
        private String href;

        public String getHref ()
        {
            return href;
        }

        public void setHref (String href)
        {
            this.href = href;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [href = "+href+"]";
        }
    }

    public class Self {
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        @Override
        public String toString() {
            return "ClassPojo [href = " + href + "]";
        }
    }

    private int numberOfGames;

    private int numberOfTeams;

    private String lastUpdated;

    private Links _links;

    private String year;

    private String caption;

    private String league;

    public int getNumberOfGames ()
    {
        return numberOfGames;
    }

    public void setNumberOfGames (int numberOfGames)
    {
        this.numberOfGames = numberOfGames;
    }

    public int getNumberOfTeams ()
    {
        return numberOfTeams;
    }

    public void setNumberOfTeams (int numberOfTeams)
    {
        this.numberOfTeams = numberOfTeams;
    }

    public String getLastUpdated ()
    {
        return lastUpdated;
    }

    public void setLastUpdated (String lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public Links get_links ()
    {
        return _links;
    }

    public void set_links (Links _links)
    {
        this._links = _links;
    }

    public String getYear ()
    {
        return year;
    }

    public void setYear (String year)
    {
        this.year = year;
    }

    public String getCaption ()
    {
        return caption;
    }

    public void setCaption (String caption)
    {
        this.caption = caption;
    }

    public String getLeague ()
    {
        return league;
    }

    public void setLeague (String league)
    {
        this.league = league;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [numberOfGames = "+numberOfGames+", numberOfTeams = "+numberOfTeams+", lastUpdated = "+lastUpdated+", _links = "+_links+", year = "+year+", caption = "+caption+", league = "+league+"]";
    }
}


