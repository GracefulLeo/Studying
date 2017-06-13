package films;

public enum Genres {
    ACTION {
        @Override
        public String toString() {
            return "Action";
        }
    },
    ADVENTURE {
        @Override
        public String toString() {
            return "Adventure";
        }
    },
    DRAMA {
        @Override
        public String toString() {
            return "Drama";
        }
    },
    FANTASY {
        @Override
        public String toString() {
            return "Fantasy";
        }
    },
    ROMANCE {
        @Override
        public String toString() {
            return "Romance";
        }
    },
    SCI_FI {
        @Override
        public String toString() {
            return "Sci-Fi";
        }
    },
    THRILLER {
        @Override
        public String toString() {
            return "Thriller";
        }
    },
}
