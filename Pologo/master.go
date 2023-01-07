package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

// Repo represents a version control repository
type Repo struct {
	Path string
}

// Init initializes a new repository at the given path
func (r *Repo) Init(path string) error {
	if _, err := os.Stat(path); !os.IsNotExist(err) {
		return fmt.Errorf("repository already exists at %s", path)
	}
	err := os.Mkdir(path, 0700)
	if err != nil {
		return err
	}
	r.Path = path
	return nil
}

// Add adds a file to the repository
func (r *Repo) Add(filename string) error {
	data, err := ioutil.ReadFile(filename)
	if err != nil {
		return err
	}
	versionsPath := filepath.Join(r.Path, "versions")
	if _, err := os.Stat(versionsPath); os.IsNotExist(err) {
		err = os.Mkdir(versionsPath, 0700)
		if err != nil {
			return err
		}
	}
	var version int
	files, err := ioutil.ReadDir(versionsPath)
	if err != nil {
		return err
	}
	if len(files) > 0 {
		latestVersion := files[len(files)-1].Name()
		version, err = strconv.Atoi(strings.TrimSuffix(latestVersion, filepath.Ext(latestVersion)))
		if err != nil {
			return err
		}
		version++
	}
	versionPath := filepath.Join(versionsPath, fmt.Sprintf("%d%s", version, filepath.Ext(filename)))
	err = ioutil.WriteFile(
	);