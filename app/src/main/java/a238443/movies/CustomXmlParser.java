package a238443.movies;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

class CustomXmlParser {
    private static final String ns = null;

    ArrayList<Movie> parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readFeed(parser);
        } finally {
            in.close();
        }
    }

    private ArrayList<Movie> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<Movie> movies = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, "feed");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("movie")) {
                movies.add(readMovie(parser));
            } else {
                skip(parser);
            }
        }
        return movies;
    }

    private Movie readMovie(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "movie");
        String title = null;
        String category = null;
        String posterPath = null;
        ArrayList<Actor> actors = new ArrayList<>();
        ArrayList<String> photosPaths = new ArrayList<>();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            switch (name) {
                case "title": title = readTitle(parser); break;
                case "category": category = readCategory(parser); break;
                case "poster": posterPath = readPoster(parser); break;
                case "actor": actors.add(readActor(parser)); break;
                case "photo": photosPaths.add(readPhoto(parser)); break;
                default: skip(parser);
            }
        }
        return new Movie(title, category, posterPath, photosPaths, actors);
    }

    private String readTitle(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "title");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "title");
        return title;
    }

    private String readCategory(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "category");
        String category = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "category");
        return category;
    }

    private String readPoster(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "poster");
        String posterPath = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "poster");
        return posterPath;
    }

    private Actor readActor(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "actor");
        String firstName = null;
        String surname = null;
        String birthDate = null;
        String photoPath = null;

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            String name = parser.getName();
            switch (name) {
                case "name": firstName = readName(parser); break;
                case "surname": surname = readSurname(parser); break;
                case "birth": birthDate = readBirth(parser); break;
                case "photo": photoPath = readPhoto(parser); break;
                default: skip(parser);
            }
        }

        return new Actor(firstName, surname, birthDate, photoPath);
    }

    private String readName(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "name");
        String name = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "name");
        return name;
    }

    private String readSurname(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "surname");
        String surname = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "surname");
        return surname;
    }

    private String readBirth(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "birth");
        String birthDate = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "birth");
        return birthDate;
    }

    private String readPhoto(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "photo");
        String photoPath = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "photo");
        return photoPath;
    }

    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
