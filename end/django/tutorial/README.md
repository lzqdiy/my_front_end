①python download and install
# Create a virtual environment to isolate our package dependencies locally
pipenv install
pipenv shell 

# start a server
pipenv run start


optional
↓
# add table of data
python manage.py makemigrations
python manage.py migrate

# Create a user
python manage.py createsuperuser
