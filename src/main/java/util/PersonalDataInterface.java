package util;

/**
 * Created by kfrak on 13.12.2018.
 */
public interface PersonalDataInterface {

    enum TYPE {
        name(new Names()), surname(new Surnames());

        private PersonalDataInterface names;

        TYPE(PersonalDataInterface names) {
            this.names = names;
        }

        public PersonalDataInterface get() {
            return names;
        };
    }
}
